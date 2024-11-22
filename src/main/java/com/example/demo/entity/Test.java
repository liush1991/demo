package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Test {


    @JsonProperty("code")
    private Integer code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("empBasInfoDTO")
        private EmpBasInfoDTODTO empBasInfoDTO;
        @JsonProperty("otherInfo")
        private OtherInfoDTO otherInfo;

        @NoArgsConstructor
        @Data
        public static class EmpBasInfoDTODTO {
            @JsonProperty("isAdd")
            private Object isAdd;
            @JsonProperty("isAddInsuEmp")
            private Object isAddInsuEmp;
            @JsonProperty("isPrnt")
            private Object isPrnt;
            @JsonProperty("conerEmail")
            private Object conerEmail;
            @JsonProperty("insuAdmdvsList")
            private Object insuAdmdvsList;
            @JsonProperty("prntLocAdmdvsList")
            private Object prntLocAdmdvsList;
            @JsonProperty("insuEmpMgtEid")
            private Object insuEmpMgtEid;
            @JsonProperty("entpSpecFlag")
            private String entpSpecFlag;
        }

        @NoArgsConstructor
        @Data
        public static class OtherInfoDTO {
            @JsonProperty("ctyPayIn")
            private Integer ctyPayIn;
            @JsonProperty("psnTratYearList")
            private List<PsnTratYearListDTO> psnTratYearList;
            @JsonProperty("STSJMons")
            private Integer sTSJMons;
            @JsonProperty("ycxbsMons")
            private Integer ycxbsMons;
            @JsonProperty("psnTratYears")
            private Integer psnTratYears;
            @JsonProperty("tzjhMons")
            private Integer tzjhMons;
            @JsonProperty("payYears")
            private Integer payYears;
            @JsonProperty("djtcMons")
            private Integer djtcMons;

            @NoArgsConstructor
            @Data
            public static class PsnTratYearListDTO {
                @JsonProperty("psnTratClctId")
                private String psnTratClctId;
                @JsonProperty("psnInsuRltsId")
                private String psnInsuRltsId;
                @JsonProperty("psnNo")
                private String psnNo;
                @JsonProperty("insutype")
                private String insutype;
                @JsonProperty("psnInsuMgtEid")
                private String psnInsuMgtEid;
                @JsonProperty("optChnl")
                private Object optChnl;
                @JsonProperty("insuplcAdmdvs")
                private String insuplcAdmdvs;
                @JsonProperty("tratClctCertfDirc")
                private String tratClctCertfDirc;
                @JsonProperty("tratClctCertfType")
                private String tratClctCertfType;
            }
        }
    }
}
