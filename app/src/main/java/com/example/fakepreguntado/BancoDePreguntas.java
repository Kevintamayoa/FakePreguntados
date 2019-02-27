package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class BancoDePreguntas {
    private List<Question> questions;

    /*
        3,"Ciencias"
        4,"Deportes"
        5,"Entretenimiento
        6,"Matemáticas"
        7,"Arte"
    * */

    public List<Question> getAllQuestions() {
        if (questions == null) {
            questions = new ArrayList<>();
            questions.add(new Question(0,"Cesar Augusto fue el primer emperador romano",true,1,0));
            questions.add(new Question(1,"Galileo Galilei fue ejecutado por afirmar que la tierra era el centro del universo",false,1,0));
            questions.add(new Question(2,"Hitler aplico a la escuela de pintura en viena en su juventud", true,2,0));
            questions.add(new Question(3,"Los antiguos atletas olimpicos jugaban desnudos",true,2,0));
            questions.add(new Question(4,"Miguel Hidalgo no tocó la \"Campana de la Independencia\"",true,3,0));
            questions.add(new Question(5,"La capital de Quintana Roo es Chetumal",true,1,1));
            questions.add(new Question(6,"La ciudad mas poblada de la republica mexicana es Oaxaca",false,1,1));
            questions.add(new Question(7,"Los estados mas grandes de México son Chihuahua, Sonora y Coahuila",true,2,1));
            questions.add(new Question(8,"La isla de Madagascar pertenece al continente Africano",true,2,1));
            questions.add(new Question(9,"El milenario árbol del Tule se puede apreciar en al bella ciudad de Mexico",false,3,1));
            questions.add(new Question(10,"La frase \"S'il vous plait\" significa: \"por favor\" en el idioma frances",true,1,2));
            questions.add(new Question(11,"En el idioma aleman la \"ss\" se escribe puede escribir como \"ß\"",false,1,2));
            questions.add(new Question(12,"La siguiente frase escrita en el idioma ingles esa correctamente escrita: \"Who's cats are using our neighbours garden?\"",false,2,2));
            questions.add(new Question(13,"La frase \"du has mich\" viene del idioma hungaro",false,2,2));
            questions.add(new Question(14,"Este ideograma chino significa \"persona\": \"人\"",false,3,2));
            questions.add(new Question(15,"",false,1,3));
            questions.add(new Question(16,"",false,1,3));
            questions.add(new Question(17,"",false,2,3));
            questions.add(new Question(18,"",false,2,3));
            questions.add(new Question(19,"",false,3,3));
            questions.add(new Question(20,"",false,1,4));
            questions.add(new Question(21,"",false,1,4));
            questions.add(new Question(22,"",false,2,4));
            questions.add(new Question(23,"",false,2,4));
            questions.add(new Question(24,"",false,3,4));
            questions.add(new Question(25,"",false,1,5));
            questions.add(new Question(26,"",false,1,5));
            questions.add(new Question(27,"",false,2,5));
            questions.add(new Question(28,"",false,2,5));
            questions.add(new Question(29,"",false,3,5));
            questions.add(new Question(30,"",false,1,6));
            questions.add(new Question(31,"",false,1,6));
            questions.add(new Question(32,"",false,2,6));
            questions.add(new Question(33,"",false,2,6));
            questions.add(new Question(34,"",false,3,6));
            questions.add(new Question(35,"",false,1,7));
            questions.add(new Question(36,"",false,1,7));
            questions.add(new Question(37,"",false,2,7));
            questions.add(new Question(38,"",false,2,7));
            questions.add(new Question(39,"",false,3,7));
        }

        return questions;
    }
}
