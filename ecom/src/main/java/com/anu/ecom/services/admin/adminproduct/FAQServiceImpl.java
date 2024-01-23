package com.anu.ecom.services.admin.adminproduct;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.anu.ecom.dto.FAQDto;
import com.anu.ecom.entity.FAQ;
import com.anu.ecom.entity.Product;
import com.anu.ecom.repository.FAQRepository;
import com.anu.ecom.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {
	
	
	private FAQRepository faqRepository;
	private ProductRepository productRepository;

	
	public FAQDto postFAQ(Long productId, FAQDto faqDto){
	Optional<Product> optionalProduct = productRepository.findById(productId);
	if(optionalProduct.isPresent()){
		FAQ faq = new FAQ();
	
		faq.setQuestion(faqDto.getQuestion());
		faq.setAnswer(faqDto.getAnswer());
		faq.setProduct(optionalProduct.get());
	
		return faqRepository.save(faq).getFAQDto();
	}
		

	return null;
	}

}