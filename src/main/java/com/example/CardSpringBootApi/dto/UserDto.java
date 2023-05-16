package com.example.CardSpringBootApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto{
        @JsonProperty
        private Long oib;
        @JsonProperty
        private String name;
        @JsonProperty
        private String surname;
        @JsonProperty
        private String status;

        public Long getOib() {
                return oib;
        }

        public void setOib(Long oib) {
                this.oib = oib;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getSurname() {
                return surname;
        }

        public void setSurname(String surname) {
                this.surname = surname;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }
}
