package com.ryazanova.MySecondTestApiSpringBoot.controller;

import com.ryazanova.MySecondTestApiSpringBoot.exception.ValidationFailedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ryazanova.MySecondTestApiSpringBoot.model.Request;
import com.ryazanova.MySecondTestApiSpringBoot.model.Response;
import com.ryazanova.MySecondTestApiSpringBoot.service.ValidationService;
import java.text.SimpleDateFormat;

