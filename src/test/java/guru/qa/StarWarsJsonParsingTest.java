package guru.qa;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.StarWarsCharacter;
import guru.qa.model.StarWarsCharacter.Starship;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StarWarsJsonParsingTest {

    ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void characterParseTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream resource = cl.getResourceAsStream("character.json");
        StarWarsCharacter jsonObject = mapper.readValue(resource, StarWarsCharacter.class);

        Starship xWing = new Starship()
            .setName("X-wing")
            .setStarshipClass("Starfighter");

        assertThat(jsonObject.getName()).isEqualTo("Luke Skywalker");
        assertThat(jsonObject.getHeight()).isEqualTo(172);
        assertThat(jsonObject.getMass()).isEqualTo(77.5);
        assertThat(jsonObject.getHairColor()).isEqualTo("blond");
        assertThat(jsonObject.getSkinColor()).isEqualTo("fair");
        assertThat(jsonObject.getEyeColor()).isEqualTo("blue");
        assertThat(jsonObject.getBirthYear()).isEqualTo("19BBY");
        assertThat(jsonObject.getGender()).isEqualTo("male");
        assertThat(jsonObject.getJedi()).isTrue();
        assertThat(jsonObject.getHomeWold().getName()).isEqualTo("Tatooine");
        assertThat(jsonObject.getHomeWold().getRotationPeriod()).isGreaterThan(22);
        assertThat(jsonObject.getHomeWold().getOrbitalPeriod()).isLessThan(305);
        assertThat(jsonObject.getHomeWold().getDiameter()).isEqualTo(10464.95);
        assertThat(jsonObject.getHomeWold().getClimate()).isEqualTo("arid");
        assertThat(jsonObject.getFilms()).contains(
            "Revenge of the Sith",
            "A New Hope",
            "The Empire Strikes Back",
            "Return of the Jedi",
            "The Force Awakens",
            "The Last Jedi",
            "The Rise of Skywalker"
        );
        assertThat(Arrays.stream(jsonObject.getStarships()).count()).isEqualTo(2);
        assertThat(Arrays.stream(jsonObject.getStarships())).contains(xWing);
    }
}
