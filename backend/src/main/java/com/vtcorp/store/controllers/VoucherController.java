package com.vtcorp.store.controllers;

import com.vtcorp.store.dtos.VoucherDTO;
import com.vtcorp.store.entities.Voucher;
import com.vtcorp.store.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vouchers")
public class VoucherController {

    private final VoucherService voucherService;

    @Autowired
    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping("/all")
    public List<Voucher> getAllVouchers() {
        return voucherService.getAllVouchers();
    }

    @GetMapping
    public List<Voucher> getActiveVouchers() {
        return voucherService.getActiveVouchers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voucher> getVoucherById(@PathVariable Long id) {
        Voucher voucher = voucherService.getVoucherById(id);
        if (voucher == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(voucher);
    }

    @PostMapping
    public ResponseEntity<?> createVoucher(@ModelAttribute VoucherDTO voucherDTO) {
        try {
            return ResponseEntity.ok(voucherService.createVoucher(voucherDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateVoucher(@PathVariable long id, @ModelAttribute VoucherDTO voucherDTO) {
        if (id != voucherDTO.getVoucherId()) {
            return ResponseEntity.badRequest().body("Voucher ID in the path variable does not match the one in the request body");
        }
        try {
            return ResponseEntity.ok(voucherService.updateVoucher(voucherDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
