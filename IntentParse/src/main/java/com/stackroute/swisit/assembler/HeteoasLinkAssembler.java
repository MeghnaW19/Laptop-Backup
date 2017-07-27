package com.stackroute.swisit.assembler;

import com.stackroute.swisit.domain.IntentParserResult;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface HeteoasLinkAssembler{

    public  List<IntentParserResult> calculateConfidence(List<IntentParserResult> results);
}