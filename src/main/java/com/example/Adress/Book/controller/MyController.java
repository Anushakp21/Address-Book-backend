package com.example.Adress.Book.controller;

import com.example.Adress.Book.requestDto.RequestDto;
import com.example.Adress.Book.responeDto.ResponseDto;
import com.example.Adress.Book.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class MyController {

    @Autowired
    AddressService addressService;

    @PostMapping("/insert")
    public ResponseDto addEmployees( @RequestBody RequestDto requestDto)
    {
        return addressService.addEmployee(requestDto);
    }

    @GetMapping
    public List<ResponseDto> getAllEmployee()
    {
        return addressService.getAllAddress();
    }

    @PutMapping("/{id}")
    public ResponseDto  updateById(@PathVariable int id,@RequestBody RequestDto requestDto)
    {
        return addressService.updateById(requestDto, id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return  addressService.deleteAddress(id);
    }

    @GetMapping("/{id}")
    public ResponseDto getByID(@PathVariable int id)
    {
        return addressService.getById(id);
    }

}
