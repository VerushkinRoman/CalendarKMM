package components

//@SuppressLint("ComposableNaming")
//@Composable
//fun BottomSheet(
//    statistic: StatisticWithDaysState,
//    onSizeMeasured: (Int) -> Unit,
//    onStatClicked: (CalendarEvent.StatisticClicked) -> Unit,
//): @Composable ColumnScope.() -> Unit = {
//    Column(
//        modifier = Modifier
//            .padding(horizontal = 16.dp, vertical = 8.dp)
//            .onGloballyPositioned { onSizeMeasured(it.size.height) }
//    ) {
//        StatisticRow(
//            name = stringResource(id = R.string.in_this_year_you_drank),
//            stat = statistic.daysOverall.size.toString(),
//            onStatClick = { onStatClicked(CalendarEvent.StatisticClicked(StatisticEntry.DaysOverall)) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        )
//
//        StatisticRow(
//            name = stringResource(id = R.string.longest_drink_marathon_in_this_year),
//            stat = statistic.drunkRowThisYear.size.toString(),
//            onStatClick = { onStatClicked(CalendarEvent.StatisticClicked(StatisticEntry.DrunkRowThisYear)) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        )
//
//        StatisticRow(
//            name = stringResource(id = R.string.longest_drink_marathon_all_time),
//            stat = statistic.drunkRowOverall.size.toString(),
//            onStatClick = { onStatClicked(CalendarEvent.StatisticClicked(StatisticEntry.DrunkRowOverall)) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        )
//
//        StatisticRow(
//            name = stringResource(id = R.string.longest_fresh_marathon_in_this_year),
//            stat = statistic.freshRowThisYear.size.toString(),
//            onStatClick = { onStatClicked(CalendarEvent.StatisticClicked(StatisticEntry.DrunkRowThisYear)) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        )
//
//        StatisticRow(
//            name = stringResource(id = R.string.longest_fresh_marathon_all_time),
//            stat = statistic.freshRowOverall.size.toString(),
//            onStatClick = { onStatClicked(CalendarEvent.StatisticClicked(StatisticEntry.FreshRowOverall)) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        )
//    }
//}