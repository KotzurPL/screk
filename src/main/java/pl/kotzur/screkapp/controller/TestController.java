package pl.kotzur.screkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kotzur.screkapp.dao.TabelaTestowaDao;
import pl.kotzur.screkapp.model.TabelaTestowa;
import pl.kotzur.screkapp.utils.Choice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    private TabelaTestowaDao tabelaTestowaDao;

    @Autowired
    public TestController(TabelaTestowaDao tabelaTestowaDao) {
        this.tabelaTestowaDao = tabelaTestowaDao;
    }

    @GetMapping("/")
    public String get(Model model) {

        List<TabelaTestowa> allRows = tabelaTestowaDao.showAll();
        model.addAttribute("rows", allRows);

        List<String> cols = tabelaTestowaDao.getColumnNames();
        model.addAttribute("cols", cols);

        model.addAttribute("myChoice", new Choice());

        return "main";

    }

    @PostMapping("/query")
    public String post(@ModelAttribute Choice choice, Model model) {

        System.out.println(choice.getColName());
        System.out.println(choice.getType());

        String par = choice.getColName();

        List<TabelaTestowa> allRows = tabelaTestowaDao.showByColumnAndType(choice.getColName(), choice.getType());

        System.out.println(allRows.toString());
        System.out.println(choice.getColName());
        model.addAttribute("rows", allRows);

        System.out.println(model.getAttribute("rows").toString());

        List<String> cols = tabelaTestowaDao.getColumnNames();
        model.addAttribute("cols", cols);

        model.addAttribute("myChoice", new Choice());

        return "main";

    }

}
