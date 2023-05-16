package com.example.CardSpringBootApi.model;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="users")
public class User {
        @Id
        @Column
        private Long oib;
        @Nonnull
        @Column
        private String name;
        @Nonnull
        @Column
        private String surname;
        @Enumerated(EnumType.STRING)
        @Column
        @Nonnull
        private UserStatus status;
        @Nullable
        @Column
        private String latestCardPath;

        public List<String> getDescriptionElements() {
                return getDescriptionElements(Optional.empty());
        }

        public List<String> getDescriptionElements(Optional<UserStatus> customStatus) {
                return Arrays.asList(oib.toString(), name, surname, customStatus.orElseGet(() -> status).name() );
        }

        public Boolean hasCardRequest() {
                return status == UserStatus.ACTIVE_CARD_REQUEST && latestCardPath != null;
        }


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

        public UserStatus getStatus() {
                return status;
        }

        public void setStatus(UserStatus status) {
                this.status = status;
        }

        public String getLatestCardPath() {
                return latestCardPath;
        }

        public void setLatestCardPath() {
                this.latestCardPath = latestCardPath;
        }
}
