package ma.fstt.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.fstt.entities.Requete;
import ma.fstt.entities.planexe;
import ma.fstt.repositories.RequeteRepo;
import ma.fstt.service.Metier;

@RestController
@RequestMapping(value = "/api/requete")

//@CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
public class RequeteController {
    @Autowired
    RequeteRepo requeteRepo;

    @Autowired
    Metier metier;

    @GetMapping
    public List<Requete> getRequete() {
        return this.requeteRepo.findAll();
    }

    @PostMapping("/valider")
    public int Valider(@RequestBody String req) {
        return this.metier.validateQuery(req);
    }

    @PostMapping("/indexes")
    public String suggestIndexes(@RequestBody String req) {
        System.out.println(this.metier.suggestIndexes(req));
        return this.metier.suggestIndexes(req);
    }

    @PostMapping("/planoptimise")
    public   List<planexe> getPlanExeOptimise(@RequestBody String requete) throws Exception{
        System.out.println("get plan optimiser");
        return this.metier.getPlanOptimise(requete);
    }

    @GetMapping("/{requete}")
    public List<Map<String, Object>> getResult(@PathVariable String requete) {
        return this.metier.getResult(requete);
    }

    @GetMapping("/plan/{requete}")
    public List<planexe> getPlanExe(@PathVariable String requete) {
        return this.metier.getPlanExe(requete);
    }

    @PostMapping
    public Requete saveRequete(@RequestBody String req) {
        Requete requete = new Requete();
        requete.setRequete(req);
        List<Map<String, Object>> resu = metier.getResult(req);
        String result_exe = "";
        List<Requete> requetes = new ArrayList<Requete>();
        for (Map<String, Object> mp : resu) {
            for (String key : mp.keySet()) {
                if (mp.get(key) != null)
                    result_exe += mp.get(key).toString();
            }
            result_exe += "\n";
        }
        requete.setResult(result_exe);
        return this.requeteRepo.save(requete);
    }
}
