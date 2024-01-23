package com.anu.ecom.services.admin.adminproduct;

import com.anu.ecom.dto.FAQDto;

public interface FAQService {
	FAQDto postFAQ(Long productId, FAQDto faqDto);
}
