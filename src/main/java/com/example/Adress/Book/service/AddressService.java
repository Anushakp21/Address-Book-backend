package com.example.Adress.Book.service;

import com.example.Adress.Book.entity.Address;
import com.example.Adress.Book.repo.AddressRepo;
import com.example.Adress.Book.requestDto.RequestDto;
import com.example.Adress.Book.responeDto.ResponseDto;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;
    public ResponseDto addEmployee(RequestDto requestDto) {

        Address address=mapToEntity(requestDto);
        address=addressRepo.save(address);

        return  mapToResponse(address);
    }

    private ResponseDto mapToResponse(Address address) {
        ResponseDto responseDto=new ResponseDto();
        responseDto.setAddressID(address.getAddressID());
        responseDto.setName(address.getName());
        responseDto.setPhone(address.getPhone());
        responseDto.setAddress(address.getAddress());
        responseDto.setState(address.getState());
        responseDto.setCity(address.getCity());
        responseDto.setZipcode(address.getZipcode());
        return responseDto;

    }

    private Address mapToEntity(RequestDto requestDto) {
        Address address=new Address(requestDto);
        return address;
    }

    public List<ResponseDto> getAllAddress() {
        List<Address> addresses=addressRepo.findAll();
        List<ResponseDto> responseDtos=new ArrayList<>();
        for(Address address:addresses)
        {
            ResponseDto responseDto=mapToResponse(address);
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }

    public ResponseDto updateById(RequestDto requestDto, int id) {

        Address address=addressRepo.findById(id).orElseThrow(() ->new RuntimeException("Address"+id+"Not Available"));
//        address.setAddressID(requestDto.getAddressID());
        address.setName(requestDto.getName());
        address.setPhone(requestDto.getPhone());
        address.setAddress(requestDto.getAddress());
        address.setState(requestDto.getState());
        address.setCity(requestDto.getCity());
        address.setZipcode(requestDto.getZipcode());
        address=addressRepo.save(address);
        return mapToResponse(address);
    }

    public String deleteAddress(int id) {
        ResponseDto existAddress=getById(id);
        addressRepo.deleteById(existAddress.getAddressID());
        return "Deleted Existing Address";
    }

    public ResponseDto getById(int id) {
    Address exitAddress=addressRepo.findById(id).orElseThrow(()->new RuntimeException("Address"+id+"not exist"));
    return  mapToResponse(exitAddress);
    }
}
