package com.example.loginactivity;

public class DataModal {

        // string variables for our name and job
        private String statuscode;
        private String messagee;

        public DataModal(String status, String meg) {
            this.statuscode = status;
            this.messagee = meg;
        }

        public String getstatusCode() {
            return statuscode;
        }

        public void setstatusCode(String ststuss) {
            this.statuscode = ststuss;
        }

        public String getmessagee() {
            return messagee;
        }

        public void setmessagee(String mess) {
            this.messagee = mess;
        }

    @Override
    public String toString() {
        return "DataModal{" +
                "statuscode='" + statuscode + '\'' +
                ", messagee='" + messagee + '\'' +
                '}';
    }
}