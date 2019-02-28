package com.example.fakepreguntado;

import java.util.ArrayList;
import java.util.List;

public class BancoDePreguntas {
    public List<Question> getAllQuestions() {
            List<Question> questions = new ArrayList<>();
            questions.add(new Question(0,"Cesar Augusto fue el primer emperador romano",0,true,1,0));
            questions.add(new Question(1,"Galileo Galilei fue ejecutado por afirmar que la tierra era el centro del universo",0,false,1,0));
            questions.add(new Question(2,"Hitler aplico a la escuela de pintura en viena en su juventud",0, true,2,0));
            questions.add(new Question(3,"Los antiguos atletas olimpicos jugaban desnudos",0,true,2,0));
            questions.add(new Question(4,"Miguel Hidalgo no tocó la \"Campana de la Independencia\"",0,true,3,0));
            questions.add(new Question(5,"La capital de Quintana Roo es Chetumal",0,true,1,1));
            questions.add(new Question(6,"La ciudad mas poblada de la republica mexicana es Oaxaca",0,false,1,1));
            questions.add(new Question(7,"Los estados mas grandes de México son Chihuahua, Sonora y Coahuila",0,true,2,1));
            questions.add(new Question(8,"La isla de Madagascar pertenece al continente Africano",0,true,2,1));
            questions.add(new Question(9,"El milenario árbol del Tule se puede apreciar en al bella ciudad de Mexico",0,false,3,1));
            questions.add(new Question(10,"La frase \"S'il vous plait\" significa: \"por favor\" en el idioma frances",0,true,1,2));
            questions.add(new Question(11,"En el idioma aleman la \"ss\" se escribe puede escribir como \"ß\"",0,false,1,2));
            questions.add(new Question(12,"La siguiente frase escrita en el idioma ingles esa correctamente escrita: \"Who's cats are using our neighbours garden?\"",0,false,2,2));
            questions.add(new Question(13,"La frase \"du has mich\" viene del idioma hungaro",0,false,2,2));
            questions.add(new Question(14,"Este ideograma chino significa \"persona\": \"人\"",0,false,3,2));
            questions.add(new Question(15,"Na es el simbolo para el elemento calcio",0,false,1,3));//Ciencias
            questions.add(new Question(16,"Es imposible estornudar con los abiertos",0,false,1,3));//Ciencias
            questions.add(new Question(17,"Solo las mosquitos hembra pican",0,true,2,3));//Ciencias
            questions.add(new Question(18,"El pingüino emperador puede permanecer bajo el agua tan solo por 5 minutos",0,false,2,3));//Ciencias
            questions.add(new Question(19,"Se cree que la Via Láctea contiene más materia oscura que Andromeda, la galaxia más grande del Grupo local",0,true,3,3));//Ciencias
            questions.add(new Question(20,"Entre 1900 y 1920, el juego de jalar la soga era un juego olímpico",0,true,1,4));//"Deportes"
            questions.add(new Question(21,"En la NBA, Magic Johnson jugó para los Lakers",0,true,1,4));//"Deportes"
            questions.add(new Question(22,"El record para el triple salto varonil es mayor a los 18 metros",0,true,2,4));//"Deportes"
            questions.add(new Question(23,"En el tenis un Deuce significa que existe un empate 60-60",0,true,2,4));//"Deportes"
            questions.add(new Question(24,"Brasil debutó en water polo en los Juegos Olimpicos del verano de 1932 y llego a las semifinales enfrentandose a alemania.",0,false,3,4));//"Deportes"
            questions.add(new Question(25,"En el juego Minecraft, un creeper es un tipo de enemigo que puede volar",0,false,1,5));//"Entretenimiento"
            questions.add(new Question(26,"En la famosa serie de comics Asterix, Obelix es el amigo fiel de Asterix",0,true,1,5));//"Entretenimiento"
            questions.add(new Question(27,"En la famosa pelicula noir Casablanca En Marruecos, el dueño de un café ayuda a su ex novia y a su marido a escapar de los nazis.",0,true,2,5));//"Entretenimiento"
            questions.add(new Question(28,"Super Mario 64 New Super Mario Bros Universe consta de 15 mundos, en las que se pueden conseguir un máximo de 3 estrellas por mundo, más una estrella que requiere 50 monedas.",0,false,2,5));//"Entretenimiento"
            questions.add(new Question(29,"En la famosa pelicula Monthy Python y el Santo Grial si una persona pesa lo mismo que un pato, entonces puede flotar y por lo mismo está hecha de madera, por lo tanto ... es una bruja",0,true,3,5));//"Entretenimiento"
            questions.add(new Question(30,"La numerologia es una rama de las matematicas",0,false,1,6));//"Matemáticas"
            questions.add(new Question(31,"La funcion inversa de una funcion exponencial es una funcion logarítmica",0,true,1,6));//Matemáticas"
            questions.add(new Question(32,"En geometría, un teseracto es una figura formada por ocho cubos tridimensionales ubicados en un espacio donde existe un cuarto eje dimensional",0,true,2,6));//Matemáticas"
            questions.add(new Question(33,"La banda o cinta de Moebius es una superficie con una sola cara y un solo borde. Tiene la propiedad matemática de ser un objeto no orientable.",0,true,2,6));//Matemáticas"
            questions.add(new Question(34,"En la sucesion de fibonacci si dividimos cada número entre su anterior nos podemos aproximar al Numero Áureo=1.618034",0,true,3,6));//Matemáticas"
            questions.add(new Question(35,"Vincent Van Gogh vendio solo 1 pintura en toda su vida",0,false,1,7));//"Arte"
            questions.add(new Question(36,"Andy Warhol conocido por haber producido imagenes de latas de sopa Campbell como obras de arte",0,true,1,7));//"Arte"
            questions.add(new Question(37,"Picasso es mayormente asociado con el impresionismo",0,false,2,7));//"Arte"
            questions.add(new Question(38,"Mary Cassatt es famosa por pintar enormes acercamientos de flores",0,false,2,7));//"Arte"
            questions.add(new Question(39,"Auguste Rodin es el creador de la escultura \"La puerta del infierno\"",0,true,3,7));//"Arte"


        return questions;
    }
}
