package be.cegeka.bibliothouris.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "/book")
@Transactional
public class BookController {
}
