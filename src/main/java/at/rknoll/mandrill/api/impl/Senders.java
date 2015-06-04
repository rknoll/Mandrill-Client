package at.rknoll.mandrill.api.impl;

import at.rknoll.mandrill.api.Request;
import at.rknoll.mandrill.api.RequestURL;

/**
 * Created by rknoll on 04/06/15.
 */
public interface Senders {

    @RequestURL("/senders/list")
    class List implements Request {
    }

    @RequestURL("/senders/domains")
    class Domains implements Request {
    }

    @RequestURL("/senders/add-domain")
    class AddDomain implements Request {
        private String domain;

        public AddDomain() {
        }

        public AddDomain(final String domain) {
            this.domain = domain;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(final String domain) {
            this.domain = domain;
        }
    }

    @RequestURL("/senders/check-domain")
    class CheckDomain implements Request {
        private String domain;

        public CheckDomain() {
        }

        public CheckDomain(final String domain) {
            this.domain = domain;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(final String domain) {
            this.domain = domain;
        }
    }

    @RequestURL("/senders/verify-domain")
    class VerifyDomain implements Request {
        private String domain;
        private String mailbox;

        public VerifyDomain() {
        }

        public VerifyDomain(final String domain, final String mailbox) {
            this.domain = domain;
            this.mailbox = mailbox;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(final String domain) {
            this.domain = domain;
        }

        public String getMailbox() {
            return mailbox;
        }

        public void setMailbox(final String mailbox) {
            this.mailbox = mailbox;
        }
    }

    @RequestURL("/senders/info")
    class Info implements Request {
        private String address;

        public Info() {
        }

        public Info(final String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

}
