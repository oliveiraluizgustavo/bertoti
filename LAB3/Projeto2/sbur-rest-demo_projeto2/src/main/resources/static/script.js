const URL = "http://localhost:8080/coffees";
let editandoId = null;

function abrirApp() {
    const splash = document.getElementById('splash');
    const main = document.getElementById('mainPage');
    splash.classList.add('opening');
    setTimeout(() => {
        splash.style.display = 'none';
        main.style.display = 'block';
        listarCafes();
        renderEditar();
        renderRemover();
        setTimeout(() => main.classList.add('visible'), 30);
    }, 850);
}

function mostrarPainel(nome, btn) {
    document.querySelectorAll('.panel').forEach(p => p.classList.remove('active'));
    document.querySelectorAll('.menu-btn').forEach(b => b.classList.remove('active'));
    document.getElementById('painel-' + nome).classList.add('active');
    btn.classList.add('active');
    if (nome === 'editar') renderEditar();
    if (nome === 'remover') renderRemover();
}

function toast(msg) {
    const t = document.getElementById('toast');
    t.textContent = msg;
    t.classList.add('show');
    setTimeout(() => t.classList.remove('show'), 2500);
}

// ── LISTAR ──────────────────────────────────────────
async function listarCafes() {
    try {
        const res = await fetch(URL);
        const cafes = await res.json();
        document.getElementById('sub-count').textContent = cafes.length + ' cafés disponíveis';
        document.getElementById('lista-cafes').innerHTML = cafes.map(c => `
      <div class="cafe-card">
        <div class="cafe-num">${c.id}</div>
        <span class="cafe-name">${c.name}</span>
      </div>`).join('');
    } catch (e) {
        console.error("Erro ao listar:", e);
    }
}

// ── ADICIONAR ───────────────────────────────────────
async function adicionarCafe() {
    const name = document.getElementById('add-nome').value.trim();
    if (!name) { alert("Preencha o nome do café!"); return; }
    await fetch(URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name })
    });
    document.getElementById('add-nome').value = '';
    await listarCafes();
    toast('Café adicionado com sucesso!');
}

// ── EDITAR ──────────────────────────────────────────
async function renderEditar() {
    try {
        const res = await fetch(URL);
        const cafes = await res.json();
        document.getElementById('form-editar').style.display = 'none';
        document.getElementById('lista-editar').innerHTML = cafes.map(c => `
      <div class="cafe-card">
        <div class="cafe-num">${c.id}</div>
        <span class="cafe-name">${c.name}</span>
        <div class="cafe-actions">
          <button class="btn-edit-sm" onclick="selecionarEditar(${c.id}, '${c.name}')">Editar</button>
        </div>
      </div>`).join('');
    } catch (e) { console.error("Erro ao carregar editar:", e); }
}

function selecionarEditar(id, name) {
    editandoId = id;
    document.getElementById('edit-nome').value = name;
    document.getElementById('form-editar').style.display = 'block';
    document.getElementById('edit-nome').focus();
}

async function salvarEdicao() {
    const name = document.getElementById('edit-nome').value.trim();
    if (!name) { alert("Preencha o nome!"); return; }
    await fetch(`${URL}/${editandoId}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: editandoId, name })
    });
    editandoId = null;
    document.getElementById('form-editar').style.display = 'none';
    await listarCafes();
    await renderEditar();
    toast('Café atualizado com sucesso!');
}

// ── REMOVER ─────────────────────────────────────────
async function renderRemover() {
    try {
        const res = await fetch(URL);
        const cafes = await res.json();
        document.getElementById('lista-remover').innerHTML = cafes.map(c => `
      <div class="cafe-card">
        <div class="cafe-num">${c.id}</div>
        <span class="cafe-name">${c.name}</span>
        <div class="cafe-actions">
          <button class="btn-del-sm" onclick="removerCafe(${c.id}, '${c.name}')">Remover</button>
        </div>
      </div>`).join('');
    } catch (e) { console.error("Erro ao carregar remover:", e); }
}

async function removerCafe(id, name) {
    if (!confirm(`Deseja remover "${name}"?`)) return;
    await fetch(`${URL}/${id}`, { method: 'DELETE' });
    await listarCafes();
    await renderRemover();
    toast('Café removido com sucesso!');
}
