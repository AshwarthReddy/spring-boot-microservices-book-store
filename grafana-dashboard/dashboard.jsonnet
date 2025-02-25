local grafana = import 'github.com/grafana/grafonnet/gen/grafonnet-latest/main.libsonnet'

local dashboard = grafana.dashboard;
local timeSeries = grafana.pannel.timeSeries;

local g = import 'g.libsonnet';

dashboard.new('Grafana DashBoard');