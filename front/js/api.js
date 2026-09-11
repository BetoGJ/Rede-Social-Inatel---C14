// ── Configuração central ──────────────────────────────────────────────────────
const API_BASE = 'http://localhost:8080/api'; // ajuste para a porta do back-end

// ── Helpers ───────────────────────────────────────────────────────────────────
async function request(method, path, body = null) {
    const opts = {
        method,
        headers: { 'Content-Type': 'application/json' },
    };
    const token = sessionStorage.getItem('token');
    if (token) opts.headers['Authorization'] = `Bearer ${token}`;
    if (body) opts.body = JSON.stringify(body);

    const res = await fetch(API_BASE + path, opts);
    const data = await res.json().catch(() => ({}));
    if (!res.ok) throw new Error(data.message || 'Erro desconhecido');
    return data;
}

// ── Auth ──────────────────────────────────────────────────────────────────────
// POST /auth/register  { email, senha }  → { token, usuario: { email } }
export const authAPI = {
    register: (email, senha) => request('POST', '/auth/register', { email, senha }),
    login:    (email, senha) => request('POST', '/auth/login',    { email, senha }),
};

// ── Salas ─────────────────────────────────────────────────────────────────────
// GET  /salas          → [{ id, nome, quantidadeUsuarios, capacidadeMaxima }]
// POST /salas/:id/join → { porta } (porta do socket da sala)
export const salasAPI = {
    listar: ()   => request('GET',  '/salas'),
    entrar: (id) => request('POST', `/salas/${id}/join`),
};
