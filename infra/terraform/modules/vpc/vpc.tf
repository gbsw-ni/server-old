resource "aws_vpc" "ni-vpc" {
  cidr_block = var.cidr_block
  tags = {
    Name = var.vpc_name
  }
}