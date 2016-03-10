package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import sun.net.www.http.HttpClient;

import com.home.project.Bill;
import com.home.project.ProductObject;
import com.home.project.WrapperList;

public class SpringRestTestClient {
	public static final String REST_SERVICE_URI = "http://localhost:8080/billing";
	public static void main(String args[])
	{
		try{
		getBill();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	private static void getBill() throws HttpClientErrorException
	{
		List<ProductObject> productObjects= new ArrayList<ProductObject>();
		productObjects.add(new ProductObject("product 1",20f,"a"));
		productObjects.add(new ProductObject("product 2",30f,"b"));
		productObjects.add(new ProductObject("product 3",40f,"c"));
		WrapperList wrapperList= new WrapperList();
		wrapperList.setProductObjects(productObjects);
		RestTemplate restTemplate=getTemplate();
		postDevice(restTemplate,wrapperList);
		
	}

	public static void postDevice(RestTemplate rest,WrapperList wrapperList) {

		//HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_XML);
		MultiValueMap<String, String> headers = 
			new LinkedMultiValueMap<String, String>(); 
			headers.add("Content-Type", "application/xml");
		

		HttpEntity entity = new HttpEntity(wrapperList, headers);
			System.out.println(entity);
		ResponseEntity response = rest.postForEntity(REST_SERVICE_URI,entity, String.class);

		String bill = (String)response.getBody();
		System.out.println(bill);
	}
	private static RestTemplate getTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		Class[] classArray= {WrapperList.class};
		
		marshaller.setClassesToBeBound(classArray);

		MarshallingHttpMessageConverter marshallingHttpConverter = new MarshallingHttpMessageConverter(marshaller);
		marshallingHttpConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_XML));
		restTemplate.getMessageConverters().add(marshallingHttpConverter);

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
		restTemplate.getMessageConverters().add(converter);

		return restTemplate;
	}
}
