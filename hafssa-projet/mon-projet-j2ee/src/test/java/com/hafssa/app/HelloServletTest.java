package com.hafssa.app;


import static org.mockito.Mockito.*; // Importer les fonctions Mockito pour le mock et la vérification
import org.junit.jupiter.api.Test; // Importer les annotations de JUnit 5
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.*; 
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServletTest {

    @Test
    public void testHelloServlet() throws ServletException, IOException {
        // Création de mocks pour les objets HttpServletRequest et HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        // Création d'un mock PrintWriter pour simuler l'écriture dans la réponse
        PrintWriter writer = mock(PrintWriter.class);
        
        // Simuler la méthode getWriter() de la réponse pour retourner le mock PrintWriter
        when(response.getWriter()).thenReturn(writer);

        // Création du servlet à tester
        HelloServlet servlet = new HelloServlet();

        // Appel de la méthode doGet du servlet
        servlet.doGet(request, response);

        // Vérifier que la méthode getWriter() a été appelée sur la réponse
        verify(response).getWriter();
        
        // Vérifier que la méthode write() a bien été appelée avec le texte attendu
        verify(writer).write("<h1>Hello depuis HelloServlet !</h1>");
    }
}