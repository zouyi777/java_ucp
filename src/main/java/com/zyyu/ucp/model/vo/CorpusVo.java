package com.zyyu.ucp.model.vo;

import com.zyyu.ucp.enums.CorpusCatgoryEnum;
import org.dozer.Mapping;

/**
 * 语料Vo
 */
public class CorpusVo extends BaseVo{

	@Mapping("id")
	private Long corpusId;
	private String content;
	private String contentMD5;
	private CorpusCatgoryEnum catgory;
	private Long donateId;
	private String donateName;

	public Long getCorpusId() {
		return corpusId;
	}

	public void setCorpusId(Long corpusId) {
		this.corpusId = corpusId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentMD5() {
		return contentMD5;
	}

	public void setContentMD5(String contentMD5) {
		this.contentMD5 = contentMD5;
	}
	public CorpusCatgoryEnum getCatgory() {
		return catgory;
	}

	public void setCatgory(CorpusCatgoryEnum catgory) {
		this.catgory = catgory;
	}

	public Long getDonateId() {
		return donateId;
	}

	public void setDonateId(Long donateId) {
		this.donateId = donateId;
	}

	public String getDonateName() {
		return donateName;
	}

	public void setDonateName(String donateName) {
		this.donateName = donateName;
	}
}
