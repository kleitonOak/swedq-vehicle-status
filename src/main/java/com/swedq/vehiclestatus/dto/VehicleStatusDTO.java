package com.swedq.vehiclestatus.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.swedq.vehiclestatus.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleStatusDTO implements Serializable {
    @NotEmpty
    @Size(min = 17, max = 17)
    private String id;
    private Date lastUpdate;
    private Status status;

    public VehicleStatusDTO(Vehicle vehicle){
        this.id = vehicle.getId();
        this.lastUpdate = vehicle.getLastUpdate();
        this.status = determineStatus(vehicle.getLastUpdate());
    }

    private Status determineStatus(Date lastUpdate) {
        Status currentStatus = Status.OFFLINE;
            if(lastUpdate != null && getMinutesDiff(lastUpdate) <= 1){
                currentStatus = Status.ONLINE;
            }
         return currentStatus;
    }

    private static long getMinutesDiff(Date lastUpdate){
            long diff = new Date().getTime() - lastUpdate.getTime();
            return (diff / (60 * 1000) % 60);
    }

//    public static void main(String[] args) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String str = "2019-07-18 12:15:00";
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//        Date lastUpdate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
//        System.out.printf("Minutes: %d", getMinutesDiff(lastUpdate));
//    }

    public enum Status{
        ONLINE("Online"),
        OFFLINE("Offline");

        private String status;
        private Status(String status){
            this.status = status;
        }

    }
}
