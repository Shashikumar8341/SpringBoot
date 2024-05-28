package com.src.tests;


import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.src.controller.EmployeController;
import com.src.entity.Employe;
import com.src.service.EmployeService;

@WebMvcTest(EmployeController.class)
public class StandaloneControllerTests {

	@MockBean
	EmployeService employeService;
	@Autowired
	MockMvc mockMvc;

	@Test
	public void testfindall() throws Exception {
		Employe employe = new Employe(1, "sk", "jk", 534526L, "knr");
		Employe employe2 = new Employe(2, "jeams", "jacks", 534528L, "krnl");
		List<Employe> empllist = Arrays.asList(employe, employe2);
	Mockito.when(employeService.findall()).thenReturn(empllist);
		 
			mockMvc.perform(get("/employes"))
			    .andExpect(status().isOk())
			    .andExpect(jsonPath("$.result", Matchers.hasSize(2)))
			    .andExpect(jsonPath("$.result[0].fname", Matchers.equalTo("sk")))
			    .andDo(MockMvcResultHandlers.print());
		
	}
	@Test
	public void testfindbyid()throws Exception{
		Employe employe = new Employe(1, "sk", "jk", 534526L, "knr");
		Mockito.when(employeService.findbyid(1)).thenReturn(employe);
		   mockMvc.perform(get("/employes/1"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.result.fname", Matchers.equalTo("sk")))
	        .andExpect(jsonPath("$.result.lname", Matchers.equalTo("jk")))
	        .andExpect(jsonPath("$.result.postralcode", Matchers.equalTo(534526)))
	        .andExpect(jsonPath("$.result.address", Matchers.equalTo("knr")))
	        .andDo(MockMvcResultHandlers.print());
		
		
	}
	 @Test
	  public void testSave() throws Exception{
		  String employeJson = "{\"fname\": \"jeams\", \"lname\": \"jacks\",\"postralcode\": 534528, \"address\": \"knrl\"}";
		  
		  Mockito.when(employeService.save(any(Employe.class))).thenReturn(new Employe(3, "jeams", "jacks", 534528L, "krnl"));
		  
		  mockMvc.perform(post("/employes")
	              .contentType(MediaType.APPLICATION_JSON)
	              .content(employeJson))
	              .andExpect(status().isOk())
	              .andExpect(jsonPath("$.result.employe_id", Matchers.equalTo(3)))
	              .andExpect(jsonPath("$.result.fname", Matchers.equalTo("jeams")))
	  	        .andExpect(jsonPath("$.result.lname", Matchers.equalTo("jacks")))
	  	        .andExpect(jsonPath("$.result.postralcode", Matchers.equalTo(534528)))
	  	        .andExpect(jsonPath("$.result.address", Matchers.equalTo("krnl")))
	              .andDo(MockMvcResultHandlers.print());
	  }
	  
	  
	  @Test
	  public void testUpdate() throws Exception{
		  String employeJson = "{\"employe_id\":\"3\",\"fname\": \"team\", \"lname\": \"jacks\",\"postralcode\": 534528, \"address\": \"knrl\"}";
		  
		  
		  mockMvc.perform(put("/employes")
	              .contentType(MediaType.APPLICATION_JSON)
	              .content(employeJson))
	              .andExpect(status().isOk())
	              .andExpect(jsonPath("$.result").value("inserted is success"))
	              .andDo(MockMvcResultHandlers.print());
	  }
	  
	  @Test
	  public void testDelete() throws Exception{
		  mockMvc.perform(delete("/employes/1"))
	              .andExpect(status().isOk())
	              .andExpect(jsonPath("$.result").value("Deleted is success"))
	              .andDo(MockMvcResultHandlers.print());
	  }
}
