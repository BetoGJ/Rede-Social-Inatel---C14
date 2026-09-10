package CRUDTestes;

import crud.Login;
import crud.LoginDAO;
import crud.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class LoginTest {
    private Login login;
    private final String email = "christopher@inatel.br";
    private final String senha = "Chizinho67!";


    @Mock
    private LoginDAO loginDAO;

    @BeforeEach
    public void setup(){
        this.login = new Login(loginDAO);
    }

    @Test
    public void testeAutentificar(){
        Usuario usuario = new Usuario(email, senha);
        Mockito.when(loginDAO.auteticaUser(email, senha)).thenReturn(true);

        boolean autenticado = login.autenticarUsuario(usuario, senha);

        assertTrue(autenticado);
        assertTrue(usuario.getLogado());
    }

    @Test
    public void testeAutenticarInvalido(){
        String senhaInvalida = "senha123";
        Usuario usuario = new Usuario(email, senha);
        Mockito.when(loginDAO.auteticaUser(email, senhaInvalida)).thenReturn(false);

        boolean autenticado = login.autenticarUsuario(usuario, senhaInvalida);

        assertFalse(autenticado);
        assertFalse(usuario.getLogado());
    }
}
