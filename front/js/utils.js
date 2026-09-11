// ── Toast ─────────────────────────────────────────────────────────────────────
export function showToast(msg, type = 'info') {
    let toast = document.getElementById('toast');
    if (!toast) {
        toast = document.createElement('div');
        toast.id = 'toast';
        toast.className = 'toast';
        document.body.appendChild(toast);
    }
    toast.textContent = msg;
    toast.className = `toast ${type} show`;
    clearTimeout(toast._t);
    toast._t = setTimeout(() => toast.classList.remove('show'), 3000);
}

// ── Auth guard ────────────────────────────────────────────────────────────────
export function requireAuth() {
    if (!sessionStorage.getItem('token')) {
        window.location.href = 'index.html';
    }
}

// ── Logout ────────────────────────────────────────────────────────────────────
export function logout() {
    sessionStorage.clear();
    window.location.href = 'index.html';
}
