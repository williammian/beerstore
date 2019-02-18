resource "aws_security_group" "allow_ssh" {
  vpc_id = "${aws_vpc.main.id}"
  name = "wm_allow_ssh"

  ingress {
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = ["191.205.121.137/32"]
  }
}

resource "aws_security_group" "database" {
  vpc_id = "${aws_vpc.main.id}"
  name = "wm_database"

  ingress {
    from_port = 5432
    to_port = 5432
    protocol = "tcp"
    self = true
  }
}