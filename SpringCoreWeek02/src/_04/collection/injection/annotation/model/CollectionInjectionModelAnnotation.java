package _04.collection.injection.annotation.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service("collectionInjectionModelAnnotationId1")
//@Component("collectionInjectionModelAnnotationId1")
//@Controller("collectionInjectionModelAnnotationId1")             //Hepsi �al���r ama kullan�ld�g� layer'a kullanmak daha mant�kl�.
@Repository("collectionInjectionModelAnnotationId1")
public class CollectionInjectionModelAnnotation {
	
	@Value(value="#{utilAnnotationList}")
	//Collectionlar� inject ederken @Autowired yerine @Resource(JDK 9 desteklemedi)
	//@Value annotationu kullan�l�r.
	private List<String> nameList; 

	
	@Value(value="#{utilAnnotationMap}")
	private Map<String, Integer> keyValueMap;

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public Map<String, Integer> getKeyValueMap() {
		return keyValueMap;
	}

	public void setKeyValueMap(Map<String, Integer> keyValueMap) {
		this.keyValueMap = keyValueMap;
	}
	
	@Override
	public String toString() {
		return "CollectionInjectionModelAnnotation [nameList=" + nameList + ", keyValueMap="
				+ keyValueMap + "]";
	}
	
}
