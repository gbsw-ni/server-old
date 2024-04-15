resource "aws_eip" "nat" {
  count = length(var.nat)
}

resource "aws_nat_gateway" "nat" {
  count         = length(var.nat)
  allocation_id = aws_eip.nat[count.index].id
  subnet_id     = var.nat[count.index].subnet_id

  tags = {
    Name = var.nat[count.index].name
  }
}