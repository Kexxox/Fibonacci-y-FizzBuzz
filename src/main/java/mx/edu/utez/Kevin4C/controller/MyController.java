package mx.edu.utez.Kevin4C.controller;

import jakarta.validation.Valid;
import mx.edu.utez.Kevin4C.controller.dto.RequestBodyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"}) //todos los origenes de peticiones
@RequestMapping("/my-services")

public class MyController {
    @GetMapping
    public String miPrimerServicio(){
        return "Hello world";
    }

    @GetMapping("/servicio2")
    public String servicio2(){
        return "segundo servicio";
    }
    @PostMapping
    public String servicip3(){
        return "Este es el servicio 3";
    }

    ///
    @GetMapping("/path/{id}")
    public String pathvariable(@PathVariable String id){
        return "El path variable es " + id;

    }
    //ResponseEntity lo requiere mucho
    @PostMapping("/body")
    public ResponseEntity<RequestBodyDTO> body(@RequestBody @Valid RequestBodyDTO payload){
        System.out.println(payload.getEdad());
        System.out.println(payload.getNombre());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(payload);
    }

    @GetMapping("/fizzbuzz/{numero}")
    public String fizzBuzz(@PathVariable int numero) {
        for (int i = 1; i <= numero; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        return "Kevin Rios Robles";
    }


    @GetMapping("/fibonacci/{numero}")
    public String fibonacci(@PathVariable int numero) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < numero; i++) {
            System.out.println(a);
            int siguiente = a + b;
            a = b;
            b = siguiente;
        }
        return "Kevin Rios Robles";
    }

}
