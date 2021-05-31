provider "aws" {
  region     = "us-east-2"
  access_key = "AKIATJ77KBHGQQ2N3OX7"
  secret_key = "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"
}

resource "aws_instance" "web-server-instance"{
  ami           = "ami-01aab85a5e4a5a0fe"
  instance_type = "t2.micro"
  #key_name      = "Jenkins"
  tags = {
    name = "webserver"
  }
}