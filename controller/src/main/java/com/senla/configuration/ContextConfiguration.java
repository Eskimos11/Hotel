package com.senla.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com"})
@EnableTransactionManagement
public class ContextConfiguration {
}
