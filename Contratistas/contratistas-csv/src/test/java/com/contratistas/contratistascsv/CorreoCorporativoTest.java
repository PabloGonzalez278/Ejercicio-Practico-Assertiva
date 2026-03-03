package com.contratistas.contratistascsv;
import com.contratistas.contratistascsv.servicios.CorreoCorporativo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CorreoCorporativoTest {

    @Test
    void shouldGenerateEmailAndDeduplicate() {

        CorreoCorporativo generator = new CorreoCorporativo();
        assertEquals("jdoe@democompany.com",
                generator.Siguiente_Correo_Corporativo("John Doe", "democompany.com"));
        assertEquals("jdoe1@democompany.com",
                generator.Siguiente_Correo_Corporativo("Johana Doe", "democompany.com"));
    }

    @Test
    void shouldFailWithSingleName() {
        CorreoCorporativo generator = new CorreoCorporativo();
        assertThrows(IllegalArgumentException.class,
                () -> generator.Siguiente_Correo_Corporativo("Madonna", "democompany.com"));
    }
}

