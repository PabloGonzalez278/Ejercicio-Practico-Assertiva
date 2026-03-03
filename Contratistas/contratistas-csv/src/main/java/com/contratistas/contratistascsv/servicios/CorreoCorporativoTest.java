package com.contratistas.contratistascsv.servicios;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CorreoCorporativoTest {
    @Test
    void shouldGenerateEmailAndDeduplicate() {
        CorporateEmailGenerator generator = new CorporateEmailGenerator();

        assertEquals("jdoe@democompany.com", generator.nextCorporateEmail("John Doe", "democompany.com"));
        assertEquals("jdoe1@democompany.com", generator.nextCorporateEmail("Johana Doe", "democompany.com"));
    }

    @Test
    void shouldNormalizeAccents() {
        CorporateEmailGenerator generator = new CorporateEmailGenerator();

        assertEquals("jgarcia@democompany.com", generator.nextCorporateEmail("José García", "democompany.com"));
    }

    @Test
    void shouldFailWithSingleName() {
        CorporateEmailGenerator generator = new CorporateEmailGenerator();

        assertThrows(IllegalArgumentException.class,
                () -> generator.nextCorporateEmail("Madonna", "democompany.com"));
    }
}


