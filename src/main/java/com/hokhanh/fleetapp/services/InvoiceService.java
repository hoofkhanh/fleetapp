package com.hokhanh.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hokhanh.fleetapp.models.Invoice;
import com.hokhanh.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public List<Invoice> getInvoices(){
		return this.invoiceRepository.findAll();
	}

	public void addNew(Invoice invoice) {
		try {
			this.invoiceRepository.save(invoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Invoice getInvoiceById(Integer id) {
		return this.invoiceRepository.findById(id).orElse(null);
	}

	public void updateInvoice(Invoice invoice) {
		try {
			this.invoiceRepository.save(invoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteInvoiceById(Integer id) {
		try {
			this.invoiceRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
