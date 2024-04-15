resource "aws_route_table_association" "ni-rta" {
  count          = length(var.asso)

  subnet_id      = var.asso[count.index].subnet_id
  route_table_id = var.asso[count.index].route_table_id
}