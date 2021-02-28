package com.ainura.must;

import com.ainura.must.domain.Anons;
import com.ainura.must.domain.Regns;
import com.ainura.must.repository.AnonsRepo;
import com.ainura.must.repository.RegnsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path="/anons")
public class AnonsController {
    @Autowired
    private AnonsRepo anonsL;
    @Autowired
    private RegnsRepo rgn;

    @GetMapping
    public String anons(Map<String, Object> model){
        Iterable<Anons> m=anonsL.findAll();
        Iterable<Regns> r=rgn.findAll();
        model.put("anonses",m);
        model.put("regns",r);

        return "anons";
    }
    @PostMapping
    public  String add(@RequestParam String text,@RequestParam Integer id,@RequestParam Integer regns, Map<String, Object> model){
//Доделаем пост и потом поиск
        Anons an= new Anons(id,text,regns);
        anonsL.save(an);
        Iterable<Anons> m=anonsL.findAll();
        model.put("anonses",m);
        Iterable<Regns> r=rgn.findAll();
        model.put("regns",r);
        return "anons";
    }
    @PostMapping("/flt")
    public  String flt(@RequestParam String fr,Map<String, Object> model) {
        Iterable<Anons> m=anonsL.findByTextStartingWith(fr);
        Iterable<Regns> r=rgn.findAll();
        model.put("anonses",m);
        model.put("regns",r);
     return "anons";
    }
    @GetMapping("/anonsupd")
    public String anonsfu(@RequestParam String anonsupd,Map<String, Object> model){
        Integer idv=Integer.valueOf(anonsupd);
        Iterable<Anons> m=anonsL.findByAnonsid(idv);
        model.put("anonses",m);
        return "anonsupd";
    }

    @PostMapping("/upd")
    public  String upd(@RequestParam String text,@RequestParam String anonsid,Map<String, Object> model) {
        Integer idv=Integer.valueOf(anonsid);
        List<Anons> m= anonsL.findByAnonsid(idv);
        Anons k= m.get(0);
        k.setText(text);
        anonsL.save(k);
        Iterable<Anons> e=anonsL.findAll();
        Iterable<Regns> r=rgn.findAll();
        model.put("anonses",e);
        model.put("regns",r);
        return "anons";
    }
}
