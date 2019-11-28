package krx.service;

import krx.model.ResultForm;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
  /**
   * http post.
   * 
   * @param url endpoint
   * @param data send data
   * @return
   */
  public ResultForm get(String url, String data) {
    RestTemplate restTemplate = new RestTemplate();

    return restTemplate.getForObject(url, ResultForm.class);
  }

  /**
   * http post.
   * 
   * @param url endpoint
   * @param data send data
   * @return
   */
  public ResultForm post(String url, Object data) {
    RestTemplate restTemplate = new RestTemplate();

    HttpEntity<MappingJacksonValue> entity =
        new HttpEntity<MappingJacksonValue>(new MappingJacksonValue(data));

    return restTemplate.postForObject(url, entity, ResultForm.class);
  }
  
  /**
   * http patch.
   * 
   * @param url endpoint
   * @param data send data
   */
  public ResultForm patch(String url, String data) {
    ClientHttpRequestFactory httpRequestFactory =  new HttpComponentsClientHttpRequestFactory();
    RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
    HttpEntity<MappingJacksonValue> entity =
        new HttpEntity<MappingJacksonValue>(new MappingJacksonValue(data));

    return restTemplate.patchForObject(url, entity, ResultForm.class);
  }

  /**
   * http put.
   * 
   * @param url endpoint
   * @param data send data
   */
  public void put(String url, String data) {
    RestTemplate restTemplate = new RestTemplate();

    HttpEntity<MappingJacksonValue> entity =
        new HttpEntity<MappingJacksonValue>(new MappingJacksonValue(data));

    restTemplate.put(url, entity);
  }
  
  /**
   * http delete.
   * 
   * @param url endpoint
   */
  public void delete(String url) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.delete(url);
  }
}
