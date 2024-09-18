package com.hotel.service.controller;

import com.hotel.service.entities.Hotel;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel hotel1 = this.hotelService.createHotel(hotel);

        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);

    }
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId)
    {
        Hotel hotel = this.hotelService.getHotel(hotelId);

        return ResponseEntity.ok().body(hotel);
    }
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin') || hasAuthority('Normal')")
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        List<Hotel> allHotels = this.hotelService.getAllHotels();
        return ResponseEntity.ok().body(allHotels);
    }

    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel)
    {
        Hotel hotel1 = this.hotelService.updateHotel(hotel);

        return ResponseEntity.ok().body(hotel1);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable("hotelId") String hotelId)
    {
        this.hotelService.deleteHotel(hotelId);
        return ResponseEntity.ok().body("Hotel deleted successfully....");
    }

}
