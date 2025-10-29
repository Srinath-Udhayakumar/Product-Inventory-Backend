package com.FirstAdi.demo.Controllers;

import com.FirstAdi.demo.dao.ProductDao;
import com.FirstAdi.demo.pojo.ApiResponseVo;
import com.FirstAdi.demo.table.ProductTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ProductController {
    @Autowired
    private ProductDao productDao;
    @PostMapping("/create")
    public ResponseEntity<ApiResponseVo> create(@RequestBody ProductTable request){
        System.out.println(request);
        if(request.getId()!=null){
            return new ResponseEntity<>(    
                    new ApiResponseVo("FAILED","Create request cannot contain ID"), HttpStatus.BAD_REQUEST
            );
        }
        productDao.save(request);
        System.out.println("Saved successfully");
        return new ResponseEntity<>(
                new ApiResponseVo("SUCCESS","Product created successfully"),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/read")
    public ResponseEntity<List<ProductTable>> read(){

        return new ResponseEntity<>(productDao.findAll(),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ApiResponseVo> update(@RequestBody ProductTable request){
        if(request.getId()==null){
            return new ResponseEntity<>(
                    new ApiResponseVo("FAILED","Required field ID is missing"), HttpStatus.BAD_REQUEST
            );
        }
        productDao.save(request);
        return new ResponseEntity<>(new ApiResponseVo("SUCESS","Product updated successfully"),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponseVo> delete(@RequestBody ProductTable request){
        productDao.delete(request);
        return new ResponseEntity<>(new ApiResponseVo("SUCCESS","Product deleted successfully"),HttpStatus.OK);
    }
}
