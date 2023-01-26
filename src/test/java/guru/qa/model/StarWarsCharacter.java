package guru.qa.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Objects;

public class StarWarsCharacter {
    private String name;
    private Integer height;
    private Double mass;
    @JsonSetter("hair_color")
    private String hairColor;
    @JsonSetter("skin_color")
    private String skinColor;
    @JsonSetter("eye_color")
    private String eyeColor;
    @JsonSetter("birth_year")
    private String birthYear;
    private String gender;
    @JsonSetter("is_jedi")
    private Boolean isJedi;
    @JsonSetter("home_world")
    private HomeWold homeWold;
    private String[] films;
    private Starship[] starships;

    public static class HomeWold {
        @JsonSetter("name")
        private String name;
        @JsonSetter("rotation_period")
        private Integer rotationPeriod;
        @JsonSetter("orbital_period")
        private Integer orbitalPeriod;
        @JsonSetter("diameter")
        private Double diameter;
        @JsonSetter("climate")
        private String climate;

        public String getName() {
            return name;
        }

        public HomeWold setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getRotationPeriod() {
            return rotationPeriod;
        }

        public HomeWold setRotationPeriod(Integer rotationPeriod) {
            this.rotationPeriod = rotationPeriod;
            return this;
        }

        public Integer getOrbitalPeriod() {
            return orbitalPeriod;
        }

        public HomeWold setOrbitalPeriod(Integer orbitalPeriod) {
            this.orbitalPeriod = orbitalPeriod;
            return this;
        }

        public Double getDiameter() {
            return diameter;
        }

        public HomeWold setDiameter(Double diameter) {
            this.diameter = diameter;
            return this;
        }

        public String getClimate() {
            return climate;
        }

        public HomeWold setClimate(String climate) {
            this.climate = climate;
            return this;
        }
    }

    public static class Starship {
        @JsonSetter("name")
        private String name;
        @JsonSetter("starship_class")
        private String starshipClass;

        public String getName() {
            return name;
        }

        public Starship setName(String name) {
            this.name = name;
            return this;
        }

        public String getStarshipClass() {
            return starshipClass;
        }

        public Starship setStarshipClass(String starshipClass) {
            this.starshipClass = starshipClass;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Starship that = (Starship) o;
            return Objects.equals(name, that.name) &&
                Objects.equals(starshipClass, that.starshipClass);
        }
    }

    public String getName() {
        return name;
    }

    public StarWarsCharacter setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public StarWarsCharacter setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Double getMass() {
        return mass;
    }

    public StarWarsCharacter setMass(Double mass) {
        this.mass = mass;
        return this;
    }

    public String getHairColor() {
        return hairColor;
    }

    public StarWarsCharacter setHairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public StarWarsCharacter setSkinColor(String skinColor) {
        this.skinColor = skinColor;
        return this;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public StarWarsCharacter setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
        return this;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public StarWarsCharacter setBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public StarWarsCharacter setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Boolean getJedi() {
        return isJedi;
    }

    public StarWarsCharacter setJedi(Boolean jedi) {
        isJedi = jedi;
        return this;
    }

    public HomeWold getHomeWold() {
        return homeWold;
    }

    public StarWarsCharacter setHomeWold(HomeWold homeWold) {
        this.homeWold = homeWold;
        return this;
    }

    public String[] getFilms() {
        return films;
    }

    public StarWarsCharacter setFilms(String[] films) {
        this.films = films;
        return this;
    }

    public Starship[] getStarships() {
        return starships;
    }

    public StarWarsCharacter setStarships(Starship[] starships) {
        this.starships = starships;
        return this;
    }
}
