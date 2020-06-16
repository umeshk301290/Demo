package com.example.demo.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.Content;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@RestController
@CrossOrigin
public class Controller {


	@Autowired
	RestTemplate template;
	
	@Autowired
	private Configuration freemarkerConfig;
	
	@Autowired
	DemoRepo repo;
	
	@Autowired
	DataRepo dataRepo;
	
	@Autowired
	Customeventpublisher publisher;
	
	@Autowired
	claimservice service;
	

	@Autowired
	parentbeandef def;
	
	 static String str;
	
		@Value("${minio.access.key}")
	    public void setDatabase(String db) {
			str = db;
	    }
	
	@GetMapping(value = "event")
	@Cacheable("hello")
	public void getEvent() {
		
		publisher.pubishEvent("hello events");
		
	}
	
	@PostMapping(value = "action")
	public void postEvent(@RequestBody AddObject object) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,Object> claimHeader = object.getClaimHeader();
		HashMap<String,String> claimInput = object.getWorkflowInput();

		publisher.pubishEvent("hello events");
		
		
	}
	@CacheEvict("hello")
	@GetMapping(value = "evictcache")
    public void getCacheEvict() {
		
      System.out.println("cache gone");		
	}
	
	@PostMapping(value = "save")
    public claim saveClaim() {
		claim c = service.createClaim();
      System.out.println("claim saved");
      return c;
	}
	
	@GetMapping(value="token")
	public void tokendata() {
		def.getBean();
	}
	
	@GetMapping(value="file")
	public void getFile(@RequestParam("file") MultipartFile file) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
	ContentDisposition dis = ContentDisposition.builder("form-data").name("file").filename("hello").build();
	fileMap.add(HttpHeaders.CONTENT_DISPOSITION, dis.toString());
	HttpEntity<byte[]> entity = new HttpEntity(file.getResource(),fileMap);
	MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
	body.add("file", entity);
	HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body,headers);
	ResponseEntity<Resource> resp = template.exchange("http://localhost:8081/temp", HttpMethod.GET, request,Resource.class); 
	System.out.println(resp.getStatusCode());
	System.out.println(resp.getBody());

		
	}

	@GetMapping(value="temp")
	public ResponseEntity<Resource> getTem(@RequestParam("file") MultipartFile file) throws IOException {
		
	byte [] b = file.getBytes();
	return  ResponseEntity.ok().body(new InputStreamResource(new ByteArrayInputStream(b)));
	 
	}
	
	
	
	@GetMapping(value="data")
	public void acceptdata() {

		
		DemoEntity demo =new 
				DemoEntity();
		demo.demoId = 3L;
		demo.name = DemoType.AAKASH;
		demo.entity = new ArrayList();
		DataEntity data = new DataEntity();
		data.dataName = "mehul";
		data.id = 3L;
		demo.entity.add(data);
		repo.save(demo);
		Optional<DemoEntity> op = repo.findById(1L);
		if(op.isPresent()) {
			DemoEntity d = op.get();
			System.out.println(d.name);
		}
					List<DemoEntity> demoList = repo.findAll();
					List<DataEntity> dataList = dataRepo.findAll();


		demoList.forEach(list -> {
			System.out.println(list.demoId);
			System.out.println(list.name);
			list.entity.forEach(li -> {
				System.out.println(li.dataName);
			});
			




		});
		
		/*dataList.forEach(list -> {
			System.out.println(list.dataName);
			System.out.println(list.demoMappingId.name);
			
			




		});
*/	}

	
	
	@GetMapping(value="hello")
	public ResponseEntity<Void> getdata() throws TemplateException {
		String db = str;
		Content emailContent = new Content();
		emailContent.setData(10);
		emailContent.setUserId("ravi");
		List<Jam> li = new ArrayList();
		Jam jam = new Jam();
		jam.setHome("1");
		jam.setNo(10);		
		Jam jam1 = new Jam();
		jam1.setHome("10");
		jam1.setNo(11);
		li.add(jam);
		li.add(jam1);
		emailContent.setListJam(li);
		List<Content> index = new ArrayList();
		index.add(emailContent);
		Map<String,Object> model = new HashMap();
		model.put("index", index);
		


		// In future this will be based on event Type
		String templateFile = "email-template.ftl";
		
/*		String temp = "<html>\r\n" + 
				"<body>\r\n" + 
				"<#list index as i>\r\n" + 
				"    <tr>demo name\r\n" + 
				"    <#list i.listJam as item>\r\n" + 
				"       <td>\r\n" + 
				"       ${item.home}\r\n" + 
				"       </td>\r\n" + 
				"       <h>java</h>\r\n" + 
				"       <td>\r\n" + 
				"       ${item.no}\r\n" + 
				"       </td>\r\n" + 
				"       </tr>\r\n" + 
				"    </#list> \r\n" + 
				"</#list>\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"";*/
		Template template = null;
		String emailContentHtml = null;
		InputStream inputStream=null;
		try {
/*			Configuration cfg = new Configuration();

			  Template t = new Template("templateName", new StringReader(temp), cfg);*/

/*			  Writer out = new StringWriter();
			  t.process(model, out);

			  String transformedTemplate = out.toString();*/
			template = freemarkerConfig.getTemplate(templateFile);
			emailContentHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
	         inputStream = new ByteArrayInputStream(emailContentHtml.getBytes(Charset.forName("UTF-8")));
	        // Files.copy(inputStream, Paths.get("d:\\he.pdf"));


		} catch (IOException i) {
			throw new NullPointerException();
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@Scheduled(cron = "0 0/1 * * * ?")
	public void getScheduling() {
		System.out.println("schedular is running without any intervention");
	}
	

	}


