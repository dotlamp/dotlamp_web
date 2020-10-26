package com.dotlamp_web.controller;

import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {com.dotlamp_web.config.RootConfig.class, com.dotlamp_web.config.ServletConfig.class})
@Log4j
public class HomeControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    public void setCtx(WebApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public  void testList() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/"))
                        .andReturn().getModelAndView().getModelMap()
        );
    }

}
