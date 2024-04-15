resource "aws_subnet" "ni-subnet" {
  count = length(var.subnet)

  vpc_id            = var.vpc_id
  cidr_block        = var.subnet[count.index].cidr_block
  availability_zone = var.subnet[count.index].availability_zone

  tags = {
    Name = var.subnet[count.index].name
  }
}