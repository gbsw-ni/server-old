resource "aws_route_table" "ni-rtb" {
  count = length(var.rtb)

  vpc_id = var.vpc_id

  tags = {
    Name = var.rtb[count.index].name
  }
}

resource "aws_route" "igw_route" {
  count                  = length(var.rtb)
  route_table_id         = aws_route_table.example[count.index].id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id             = var.rtb[count.index].gateway_id
}
