/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacob.controllers;

import com.jacob.models.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jacobh
 */


public class HomeController {
    
    private JdbcTemplate jdbcTemplate;

    public HomeController() {
        
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    
    
    @RequestMapping("home.html")
    public ModelAndView home (){
        
        ModelAndView mav = new ModelAndView();
        String sql= "select * from usuarios order by nombre desc;";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos",datos);
        mav.setViewName("home");
        return mav;
    }
}
