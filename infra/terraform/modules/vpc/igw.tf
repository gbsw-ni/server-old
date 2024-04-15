resource "aws_internet_gateway" "ni-igw" {
  vpc_id = var.vpc_id

  tags = {
    Name = var.igw
  }
}