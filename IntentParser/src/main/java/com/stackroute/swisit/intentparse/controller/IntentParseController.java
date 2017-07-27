package com.stackroute.swisit.intentparse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.swisit.intentparse.domain.IntentParser;
import com.stackroute.swisit.intentparse.domain.WordIntensity;
import com.stackroute.swisit.intentparse.service.CCalculatorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="SWIS-it", description="Operations pertaining to the SWIS-it")
@RestController
@RequestMapping("swisit/parse")
public class IntentParseController {
	
	@Autowired
	CCalculatorService cCalculatorService;

	
	@ApiOperation(value = "View the JSON from the crawler service",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved JSON"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	
//  @ApiOperation(value = "")
	@RequestMapping(value = "", method= RequestMethod.POST)
	public ResponseEntity<Float> calculateConfidenceScore(@RequestBody IntentParser[] intentParserArr, Model model){

		List<WordIntensity> wordIntensityList = new ArrayList<>();
//		WordIntensity wordIntensity; 

		cCalculatorService.intentParserResult(intentParserArr);
		return null;
    	

	}
}


