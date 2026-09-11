// Abstração do WebSocket — espelha ClienteSocket.java (ReceberMensagem / EnviarMensagem)
// O back deve expor um WebSocket em ws://localhost:<porta>/chat/<salaId>

export class ChatSocket {
    constructor(salaId, porta) {
        // porta vem de salasAPI.entrar(id) → { porta }
        const WS_BASE = `ws://localhost:${porta}/chat/${salaId}`;
        this._ws = new WebSocket(WS_BASE);
        this._handlers = { message: [], open: [], close: [], error: [] };

        this._ws.onopen    = () => this._emit('open');
        this._ws.onclose   = () => this._emit('close');
        this._ws.onerror   = (e) => this._emit('error', e);
        this._ws.onmessage = (e) => {
            // Protocolo esperado: JSON { tipo, autor, conteudo, timestamp }
            try { this._emit('message', JSON.parse(e.data)); }
            catch { this._emit('message', { tipo: 'texto', autor: '?', conteudo: e.data }); }
        };
    }

    // Equivalente a EnviarMensagem(String)
    enviar(conteudo) {
        if (this._ws.readyState !== WebSocket.OPEN) return;
        this._ws.send(JSON.stringify({ conteudo }));
    }

    on(event, fn) { this._handlers[event]?.push(fn); return this; }

    fechar() { this._ws.close(); }

    _emit(event, data) { this._handlers[event]?.forEach(fn => fn(data)); }
}
